//
//  PIQuestionsApi.m
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "PIQuestionsApi.h"
#import "PIDataManager.h"

@implementation PIQuestionsApi

-(instancetype)init{
    if(self = [super init]){
    }
    return self;
}

- (NSString *)urlForAPIRequest{
    return [NSString stringWithFormat:@"%@/5560532058b1743a027eedae",[super baseURL]];
}

- (NSMutableDictionary *)requestParameters{
    return [NSMutableDictionary new];
}

- (NSString *)requestType{
    return APIGet;
}

- (void)parseAPIResponse:(NSDictionary *)responseDictionary{
    [super parseAPIResponse:responseDictionary];
}

@end
