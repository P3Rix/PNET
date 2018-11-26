const express = require('express');
const app = express();
const logger = require('morgan');
const http = require('http');
const path = require('path');
const PORT = process.env.PORT || 8080;
const bodyParser = require('body-parser');
const baseAPI = '/api/v1';
const mobiles = require('./routes/mobiles');
const mobilesService = require('./routes/mobiles-service');
const cors = require('cors');

app.use(cors());


app.use(bodyParser.json());
app.use(logger('dev'));
app.use(bodyParser.urlencoded({
extended: true
}));

app.get('/', function (req, res) {
    res.send('Hello World!');
    });

app.use('/mobiles', mobiles);
    
const server = http.createServer(app);
mobilesService.connectDb(function (err) {
    if (err) {
    console.log("Could not connect with MongoDB - moviesService");
    process.exit(1);
    }
    server.listen(PORT, function () {
    console.log('Server up and running on localhost:' + PORT);
    });
});
