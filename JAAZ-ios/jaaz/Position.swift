//
//  Position.swift
//  jaaz
//
//  Created by Aritro Majumdar on 10/22/17.
//  Copyright © 2017 Team 17. All rights reserved.
//

import UIKit
import FirebaseFirestore

class Position {

    var positionArr = [Record]()
    
    func addRecord(h1: String, m1: String, e1: String, a1: String, z1: Int, ab1: String ){
        let newRec = Record(h: h1, m: m1, e: e1, a: a1, z: z1, ab: ab1)
            positionArr.append(newRec)
        
    }
    
    
    
    
}


class Record{
    var hs: String?
    var mi: String?
    var es: String?
    var address: String?
    var zip: Int?
    var about: String?
    
    init(h: String, m: String, e: String, a: String, z: Int, ab: String){
        hs = h
        mi = m
        es = e
        address = a
        zip = z
        about = ab
    }
    
    internal func getHS()->String{
        return hs!
    }
    
    internal func getMi()->String{
        return mi!
    }
    internal func getEs()->String{
        return es!
    }
    internal func getAddress()->String{
        return address!
    }
    internal func getZip()->Int{
        return zip!
    }
    internal func getAbout()-> String{
        return about!
    }
    
}
