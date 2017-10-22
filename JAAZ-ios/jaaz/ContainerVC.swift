//
//  ContainerVC.swift
//  jaaz
//
//  Created by Aritro Majumdar on 10/22/17.
//  Copyright © 2017 Team 17. All rights reserved.
//

import Foundation
import UIKit
class ContainerVC: UIViewController{
    
    @IBOutlet weak var sideMenuConstraint: NSLayoutConstraint!
    
    var sideMenoOpen = false
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        NotificationCenter.default.addObserver(self, selector: #selector(toggleSideMenu), name: NSNotification.Name("ToggleSideMenu"), object: nil)
    }
    @objc func toggleSideMenu(){
        if sideMenoOpen{
            sideMenuConstraint.constant = -240
            sideMenoOpen = false
        }
        else{
            sideMenuConstraint.constant = 0
            sideMenoOpen = true
        }
        UIView.animate(withDuration: 0.3){
            self.view.layoutIfNeeded()
        }
    }
    


}
