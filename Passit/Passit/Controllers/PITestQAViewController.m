//
//  PITestQAViewController.m
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "PITestQAViewController.h"
#import "PIQAListTableViewCell.h"
#import "PIDataManager.h"

@interface PITestQAViewController (){
    NSInteger currentIndex;
    NSDictionary *currentQuestion;
    NSTimer *timer;
    NSInteger elapsedSeconds;
}
@property (weak, nonatomic) IBOutlet UIButton *previousButton;
@property (weak, nonatomic) IBOutlet UIButton *nextButton;
@property (weak, nonatomic) IBOutlet UITableView *answersTableView;
@property (weak, nonatomic) IBOutlet UITextView *questionTextView;
@property (weak, nonatomic) IBOutlet UILabel *timerLabel;

@end

@implementation PITestQAViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    elapsedSeconds = 0;
    currentQuestion = [NSDictionary new];
    currentIndex = 0;
    currentQuestion = (NSDictionary *)[[[PIDataManager sharedInstance] questionsArray] objectAtIndex:currentIndex];
    self.questionTextView.text = @"";
    self.questionTextView.text = currentQuestion[@"question"];
    [self.answersTableView reloadData];
    self.previousButton.enabled = NO;
    
    timer = [NSTimer scheduledTimerWithTimeInterval:1.0 target:self selector:@selector(updateTimer) userInfo:nil repeats:YES];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)previousButtonAction:(id)sender {
    if (currentIndex <= 0) {
        self.previousButton.enabled = NO;
        return;
    }else{
        self.previousButton.enabled = YES;
        currentIndex -= 1;
    }
    currentQuestion = (NSDictionary *)[[[PIDataManager sharedInstance] questionsArray] objectAtIndex:currentIndex];
    self.questionTextView.text = @"";
    self.questionTextView.text = currentQuestion[@"question"];
    [UIView animateWithDuration:0.25 delay:0 options:UIViewAnimationOptionTransitionCrossDissolve animations:^{
        ;
    } completion:^(BOOL finished) {
        [self.answersTableView reloadData];
    }];
}

- (IBAction)nextButtonAction:(id)sender {
    self.previousButton.enabled = YES;
    currentIndex += 1;
    if (currentIndex >= [[[PIDataManager sharedInstance] questionsArray] count]) {
        UIAlertView *alertView = [[UIAlertView alloc] initWithTitle:@"Hackthlon" message:@"Thanks for your participation" delegate:self cancelButtonTitle:@"OK" otherButtonTitles: nil];
        [alertView show];
        [timer invalidate];
        return;
    }
    currentQuestion = (NSDictionary *)[[[PIDataManager sharedInstance] questionsArray] objectAtIndex:currentIndex];
    self.questionTextView.text = @"";
    self.questionTextView.text = currentQuestion[@"question"];
    [UIView animateWithDuration:0.25 delay:0 options:UIViewAnimationOptionTransitionCrossDissolve animations:^{
        ;
    } completion:^(BOOL finished) {
        [self.answersTableView reloadData];
    }];
}

- (void)alertView:(UIAlertView *)alertView clickedButtonAtIndex:(NSInteger)buttonIndex {
    if (buttonIndex == 0) {
        [self.navigationController popToRootViewControllerAnimated:YES];
    }
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return 4;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    PIQAListTableViewCell *cell = (PIQAListTableViewCell*)[tableView dequeueReusableCellWithIdentifier:@"Cell" forIndexPath:indexPath];
    NSDictionary *answersDictionary = currentQuestion[@"answers"];
    switch (indexPath.row) {
        case 0:
            cell.cellTestLabel.text = answersDictionary[@"1"];
            break;
        case 1:
            cell.cellTestLabel.text = answersDictionary[@"2"];
            break;
        case 2:
            cell.cellTestLabel.text = answersDictionary[@"3"];
            break;
        case 3:
            cell.cellTestLabel.text = answersDictionary[@"4"];
            break;
        default:
            break;
    }
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    
//    [self.navigationController popToRootViewControllerAnimated:YES];
}

- (void)updateTimer {
    self.timerLabel.text = [self timeString];
    elapsedSeconds++;
}

- (NSString*)timeString {
    NSInteger min = elapsedSeconds/60;
    NSInteger seconds = elapsedSeconds - (min*60);
    return [NSString stringWithFormat:@"%02ld:%02ld",(long)min,(long)seconds];
}

- (void)dealloc {
    [timer invalidate];
    timer = nil;
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
