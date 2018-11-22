'use strict';

const express = require('express');
const router = express.Router();
const mobilesService = require('./mobiles-service');

router.get('/', function (req, res) {
    mobilesService.getAll((err, mobiles) => {
            if (err) {
                res.status(500).send({
                    msg: err
                });
            } else if (mobiles === null){
                res.status(500).send({
                    msg: "mobiles null"
                });
            } else if (mobiles !== null) {
                res.status(200).send(mobiles);
            }
        }
    );
});

router.post('/', function (req, res) {
    let mobile = req.body;
    mobilesService.add(mobile, (err, mobile) => {
            if (err) {
                res.status(500).send({
                    msg: err
                });
            } else if (mobile !== null) {
                res.send({
                    msg: 'Mobile created!'
                });
            }
        }
    );
});

router.delete('/', function (req, res) {
    mobilesService.removeAll((err) => {
        if (err) {
            res.status(500).send({
                msg: err
            });
        } else {
            res.status(200).send({
                msg: 'Mobiles deleted!'
            });
        }
    });
});

router.put('/:_id', function (req, res) {
    const _id = req.params._id;
    const updatedMobile = req.body;
    mobilesService.update(_id, updatedMobile, (err, numUpdates) => {
        if (err || numUpdates === 0) {
            res.status(500).send({
                msg: err
            });
        } else {
            res.status(200).send({
                msg: 'Mobile updated!'
            });
        }
    });
});

router.delete('/:_id', function (req, res) {
    let _id = req.params._id;
    mobilesService.remove(_id, (err) => {
        if (err) {
            res.status(404).send({
                msg: err
            });
        } else {
            res.status(200).send({
                msg: 'Mobile deleted!'
            });
        }
    });
});


router.get('/:_id', function (req, res) {
    let _id = req.params._id;
    mobilesService.get(_id, (err, mobile) => {
            if (err) {
                res.status(500).send({
                    msg: err
                });
            } else if (mobile === null){
                res.status(500).send({
                    msg: "Mobile null"
                });
            } else if (mobile !== null) {
                res.status(200).send(mobile);
            }
        }
    );
});

module.exports = router;