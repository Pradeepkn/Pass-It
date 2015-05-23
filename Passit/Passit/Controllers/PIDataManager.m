//
//  PIDataManager.m
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "PIDataManager.h"

@implementation PIDataManager

+ (PIDataManager *)sharedInstance
{
    static PIDataManager *sharedInstance = nil;
    static dispatch_once_t onceToken;
    
    dispatch_once(&onceToken, ^{
        sharedInstance = [[super allocWithZone:NULL] init];
        sharedInstance.companyArray = [[NSMutableArray alloc] init];
        sharedInstance.questionsArray = [[NSMutableArray alloc] init];
    });
    
    return sharedInstance;
}


@end
