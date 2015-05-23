//
//  PITestLaunchViewController.m
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "PITestLaunchViewController.h"
#import "Constants.h"

@interface PITestLaunchViewController ()

@property (weak, nonatomic) IBOutlet UIButton *startButton;
@property (weak, nonatomic) IBOutlet UILabel *testHeaderLabel;
@end

@implementation PITestLaunchViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)initializeViewLayouts {
    self.startButton.layer.shadowOffset = CGSizeMake(1, 1);
    self.startButton.layer.shadowColor = [[UIColor lightGrayColor] CGColor];
    self.startButton.layer.masksToBounds = NO;
    self.startButton.layer.shadowOpacity = 0.80f;
    self.startButton.layer.shadowRadius = 1.0f;
    self.startButton.layer.cornerRadius = 3.0f;
}

- (IBAction)startButtonClicked:(id)sender {
    [self performSegueWithIdentifier:kQAListViewSegue sender:nil];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
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
