//
//  PISettingsViewController.m
//  Passit
//
//  Created by Selvin on 23/05/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "PISettingsViewController.h"
#import "AppDelegate.h"

@implementation PISettingsViewController

- (IBAction)logoutButtonTouched:(id)sender {
    AppDelegate *appdelegate = [[UIApplication sharedApplication]delegate];
    [appdelegate logout];
}

@end
