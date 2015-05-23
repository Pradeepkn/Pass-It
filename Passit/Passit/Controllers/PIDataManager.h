//
//  PIDataManager.h
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface PIDataManager : NSObject

@property (nonatomic, strong) NSMutableArray *companyArray;
@property (nonatomic, strong) NSMutableArray *questionsArray;

/*!
 @abstract Shared instance to get and to store app data
 @discussion This class will made available through out app to access data
 @return sharedInstance
 @since 1.0
 */
+ (id)sharedInstance;

- (NSString *)getQuestionsResponse;

@end
