//
//  PILaunchViewController.m
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "PILaunchViewController.h"
#import "TestModel.h"
#import "PITestListCell.h"
#import "PITestLaunchViewController.h"

@interface PILaunchViewController ()
// To hold the reference of the companies and the tests
@property (nonatomic, strong) NSMutableArray *companyList;

@end

@implementation PILaunchViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
    
    _companyList = [NSMutableArray new];
    
    {
        TestModel *model = [[TestModel alloc]initWithCompanyID:@1 companyName:@"Volkswagon" testDescription:@"Hackathon pre screening for mobile devs"];
        [_companyList addObject:model];
    }
    
    {
        TestModel *model = [[TestModel alloc]initWithCompanyID:@2 companyName:@"Dell" testDescription:@"Dell inspiring you"];
        [_companyList addObject:model];
    }
    
    {
        TestModel *model = [[TestModel alloc]initWithCompanyID:@3 companyName:@"Intel" testDescription:@"The future is here. ObjectiveC, Swift"];
        [_companyList addObject:model];
    }
    [self.tableView reloadData];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    
    // Return the number of sections.
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    
    // Return the number of rows in the section.
    return _companyList.count;
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    PITestListCell *cell           = [tableView dequeueReusableCellWithIdentifier:@"PITestListCell" forIndexPath:indexPath];
    TestModel *model               = _companyList[indexPath.row];
    cell.companyNameLabel.text     = model.companyName;
    cell.testDescriptionLabel.text = model.testDescription;
    [cell.companyLogo setImage:[UIImage imageNamed:[NSString stringWithFormat:@"%ld.png",(long)indexPath.row + 1]]];
    return cell;
}


- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    TestModel *model = _companyList[indexPath.row];
    UIStoryboard *testStoryboard = [UIStoryboard storyboardWithName:@"QAStoryboard" bundle:[NSBundle mainBundle]];
    PITestLaunchViewController *testLaunchVC = [testStoryboard instantiateViewControllerWithIdentifier:@"PITestLaunchViewController"];
    testLaunchVC.model = model;
    [self.navigationController pushViewController:testLaunchVC animated:YES];
    
    
}

/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
    } else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
    }   
}
*/

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath {
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
