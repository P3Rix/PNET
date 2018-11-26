'use strict';

const MongoClient = require('mongodb').MongoClient;
let db;
let ObjectId = require('mongodb').ObjectID;
const Mobiles = function () {
};

Mobiles.prototype.connectDb = function (callback) {
    MongoClient.connect("mongodb://admin:admin1@ds039351.mlab.com:39351/pnet-joseperinan",
        {useNewUrlParser: true},
        function (err, database) {
            if (err) {
                callback(err);
            }

            db = database.db('pnet-joseperinan').collection('mobiles');

            callback(err, database);
        });
};

Mobiles.prototype.add = function (mobile, callback) {
    return db.insert(mobile, callback);
};

Mobiles.prototype.get = function (_id, callback) {
    return db.find({name: ObjectId(_id)}).toArray(callback);
};

Mobiles.prototype.getAll = function (callback) {
    return db.find({}).toArray(callback);
}; 

Mobiles.prototype.update = function (_id, updatedMobile, callback) {
    delete updatedMobile._id;
    return db.updateOne({_id: ObjectId(_id)}, {$set:
    updatedMobile}, callback);};

Mobiles.prototype.remove = function (_id, callback) {
    return db.deleteOne({_id: ObjectId(_id)}, callback);
};

Mobiles.prototype.removeAll = function (callback) {
    return db.deleteMany({}, callback);
};


module.exports = new Mobiles();