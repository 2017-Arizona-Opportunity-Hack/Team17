//
//  MainMenuVC.swift
//  jaaz
//
//  Created by Aritro Majumdar on 10/22/17.
//  Copyright © 2017 Team 17. All rights reserved.
//

import UIKit
import FirebaseFirestore

class MainMenuVC: UIViewController{

    var db: DocumentReference?
    

    override func viewDidLoad() {
        super.viewDidLoad()
        
        
    }
    func extractData(){
        var red = db?.collection("positions")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
        
    }
    


    @IBAction func onMoreTapped(){
    print("Toggle Side Menu")
        NotificationCenter.default.post(name: NSNotification.Name("ToggleSideMenu"), object: nil)
    }

}
