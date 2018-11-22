'use strict';

const MongoClient = require('mongodb').MongoClient;
let db;
let ObjectId = require('mongodb').ObjectID;
const Users = function () {
};

Users.prototype.connectDb = function (callback) {
    MongoClient.connect("mongodb://admin:admin1@ds039351.mlab.com:39351/pnet-joseperinan",
        {useNewUrlParser: true},
        function (err, database) {
            if (err) {
                callback(err);
            }

            db = database.db('pnet-joseperinan').collection('users');

            callback(err, database);
        });
};

Users.prototype.add = function (user, callback) {
    return db.insert(user, callback);
};

Users.prototype.get = function (_id, callback) {
    return db.find({_id: ObjectId(_id)}).toArray(callback);
};

Users.prototype.getAll = function (callback) {
    return db.find({}).toArray(callback);
};

Users.prototype.update = function (_id, updatedUser, callback) {
    delete updatedMobile._id;
    return db.updateOne({_id: ObjectId(_id)}, {$set: updatedUser}, callback);};

Users.prototype.remove = function (_id, callback) {
    return db.deleteOne({_id: ObjectId(_id)}, callback);
};

Users.prototype.removeAll = function (callback) {
    return db.deleteMany({}, callback);
};

module.exports = new Users();