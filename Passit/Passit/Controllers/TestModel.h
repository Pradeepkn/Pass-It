//
//  TestModel.h
//  Passit
//
//  Created by Selvin on 23/05/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface TestModel : NSObject

@property (nonatomic, strong) NSString *companyName;
@property (nonatomic, strong) NSNumber *companyID;
@property (nonatomic, strong) NSString *testDescription;


- (instancetype)initWithCompanyID:(NSNumber*)companyID
                      companyName:(NSString*)companyName
                  testDescription:(NSString*)testDescription;

@end
