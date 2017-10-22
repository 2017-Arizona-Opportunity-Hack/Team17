//
//  SideMenuBar.swift
//  jaaz
//
//  Created by Aritro Majumdar on 10/22/17.
//  Copyright © 2017 Team 17. All rights reserved.
//

import UIKit

class SideMenuBar: UITableViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Uncomment the following line to preserve selection between presentations
        // self.clearsSelectionOnViewWillAppear = false

        // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
        // self.navigationItem.rightBarButtonItem = self.editButtonItem
    }

    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        print(indexPath.row)
    }

}
