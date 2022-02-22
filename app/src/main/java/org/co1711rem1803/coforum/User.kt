package org.co1711rem1803.coforum

class User {

    var emailId : String? = null
    var fullName : String? = null
    var userName : String? = null
    var dateOfBirth : String? = null
    var uid : String? = null
    var panel : String? = null
    var year : Int? = null

    constructor(){}

    constructor(_emailID:String,_uid:String,_fullName:String,_userName:String,_dateOfBirth : String){
        this.emailId = _emailID
        this.fullName = _fullName
        this.userName = _userName
        this.dateOfBirth = _dateOfBirth
        this.uid = _uid
    }
}