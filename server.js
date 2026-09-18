const express = require('express');
const client = require('prom-client');

const app = express();
const PORT = process.env.PORT || 3000;

let isReady = true;

// Métriques Prometheus par défaut (CPU, mémoire, boucle d'événements)
const collectDefaultMetrics = client.collectDefaultMetrics;
collectDefaultMetrics();

// Métrique personnalisée : compteur de requêtes HTTP
const httpRequestsTotal = new client.Counter({
  name: 'http_requests_total',
  help: 'Nombre total de requetes HTTP recus',
  labelNames: ['method', 'path', 'status']
});

app.use((req, res, next) => {
  res.on('finish', () => {
    httpRequestsTotal.inc({
      method: req.method,
      path: req.route ? req.route.path : req.path,
      status: res.statusCode
    });
  });
  next();
});

// 1. Route métier
app.get('/api/data', (req, res) => {
  res.json({ message: "Reponse metier valide", timestamp: new Date() });
});

// 2. Tests de vie (Liveness & Readiness)
app.get('/healthz', (req, res) => {
  res.status(200).send('OK');
});

app.get('/ready', (req, res) => {
  if (isReady) {
    res.status(200).send('READY');
  } else {
    res.status(503).send('NOT_READY');
  }
});

app.post('/toggle-ready', (req, res) => {
  isReady = !isReady;
  res.send(`Statut de readiness: ${isReady}`);
});

// 3. Stress test (boucle intensive)
app.get('/stress', (req, res) => {
  const duration = parseInt(req.query.duration || '2000', 10);
  const end = Date.now() + duration;
  while (Date.now() < end) {
    Math.sqrt(Math.random());
  }
  res.send(`Stress effectue pendant ${duration} ms`);
});

// 4. Endpoint Prometheus
app.get('/metrics', async (req, res) => {
  res.set('Content-Type', client.register.contentType);
  res.end(await client.register.metrics());
});

const server = app.listen(PORT, '0.0.0.0', () => {
  console.log(`Application demarree sur le port ${PORT}`);
});

module.exports = { app, server };
