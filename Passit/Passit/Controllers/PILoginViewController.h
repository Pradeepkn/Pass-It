//
//  PILoginViewController.h
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "PIBaseViewController.h"

@protocol PILoginDelegate <NSObject>

/*!
 @abstract To let the delegate know that login is succeeded
 
 @since 1.0
 */
- (void)loginDidSuccess;

@end

/*!
 @discussion To handle login logic
 
 ## Version information
 
 __Version__: 1.0
 
 __Found__: 5/23/15.
 
 __Last update__: 5/23/15.
 
 __Developer__: Selvin, Tarento Technologies Pvt Ltd.
 
 */
@interface PILoginViewController : PIBaseViewController

@property (nonatomic, weak) id<PILoginDelegate> delegate;

@end
