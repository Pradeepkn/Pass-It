//
//  PILoginViewController.m
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "PILoginViewController.h"

static  NSString* dummyusername = @"appsoldier";
static  NSString* dummypassword = @"qwerty";

@interface PILoginViewController ()

@property (weak, nonatomic) IBOutlet UITextField *usernameTextField;
@property (weak, nonatomic) IBOutlet UITextField *passwordTextField;

@end

@implementation PILoginViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)didPressLoginButton:(id)sender {
//    if ([self.usernameTextField.text isEqualToString:dummyusername] &&
//        [self.passwordTextField.text isEqualToString:dummypassword]) {
        if ([self.delegate respondsToSelector:@selector(loginDidSuccess)]) {
            [[NSUserDefaults standardUserDefaults]setBool:YES forKey:PIIsUserLoggedIn];
            [self.delegate loginDidSuccess];
        }
//    }
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
