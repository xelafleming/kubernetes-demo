var express = require("express");
var app = express();

app.listen(3000, () => console.log("Listening on port 3000..."));

app.get("/identity", (_req, res, _next) => {
  res.json({ podIdentifier: process.env.HOSTNAME });
});
