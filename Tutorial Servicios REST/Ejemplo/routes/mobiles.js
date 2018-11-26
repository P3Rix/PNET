'use strict';

let mobiles = [
    {
        "marca":"Xiaomi",
        "modelo":"Xiaomi Mi A2 4GB+64GB",
        "precio":234
    },
    {
        "marca": "Samsung",
        "modelo": "Samsung s9",
        "precio": 602
    }
    ];

const express = require('express');
const router = express.Router();

router.get('/', function (req, res) {
    res.send(mobiles);
    });

router.post('/', function (req, res) {
    mobiles.push(req.body);
    res.status(201).send("Mobiles created");
    });

router.delete('/', function (req, res) {
    mobiles = [];
    res.status(200).send("Mobiles deleted");
    });

router.get('/:marca', function (req, res) {
    let marca = req.params.marca;
    res.send(mobiles.filter(m => m.marca === marca));
    });

router.put('/:marca', function (req, res) {
    let marca = req.params.marca;
    mobiles = mobiles.filter(m => m.marca !== marca);
    mobiles.push(req.body);
    res.status(200).send("Mobiles updated!");
    });
        
module.exports = router;


        