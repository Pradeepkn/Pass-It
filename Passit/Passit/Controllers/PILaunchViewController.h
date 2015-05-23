//
//  PILaunchViewController.h
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <SideMenu/SideMenu-Swift.h>

@class PILaunchViewController;

@protocol MenuViewControllerDelegate <NSObject>

- (void)menu:(PILaunchViewController*)menu didSelectItemAtIndex:(NSInteger)index atPoint:(CGPoint)point;

- (void)menuDidCancel:(PILaunchViewController*)menu;

@end


@interface PILaunchViewController : UITableViewController

@property (nonatomic, weak) id<MenuViewControllerDelegate> delegate;

@end
