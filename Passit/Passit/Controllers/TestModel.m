//
//  TestModel.m
//  Passit
//
//  Created by Selvin on 23/05/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "TestModel.h"

@implementation TestModel

- (instancetype)initWithCompanyID:(NSNumber *)companyID companyName:(NSString *)companyName testDescription:(NSString *)testDescription {
    if (self = [super init]) {
        self.companyID = companyID;
        self.companyName = companyName;
        self.testDescription = testDescription;
    }
    return self;
}

@end
