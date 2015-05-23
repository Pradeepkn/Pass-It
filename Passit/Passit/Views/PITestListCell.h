//
//  PITestListCell.h
//  Passit
//
//  Created by Selvin on 23/05/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface PITestListCell : UITableViewCell

@property (weak, nonatomic) IBOutlet UILabel *companyNameLabel;
@property (weak, nonatomic) IBOutlet UILabel *testDescriptionLabel;
@property (weak, nonatomic) IBOutlet UIImageView *companyLogo;

@end
