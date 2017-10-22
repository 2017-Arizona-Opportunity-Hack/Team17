//
//  MainMenuVC.swift
//  jaaz
//
//  Created by Aritro Majumdar on 10/22/17.
//  Copyright © 2017 Team 17. All rights reserved.
//

import UIKit

class MainMenuVC: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
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
