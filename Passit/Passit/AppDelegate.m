//
//  AppDelegate.m
//  Passit
//
//  Created by Pradeep on 5/23/15.
//  Copyright (c) 2015 App Soldiers. All rights reserved.
//

#import "AppDelegate.h"
#import "PILoginViewController.h"
#import "PILaunchViewController.h"
#import "PITestLaunchViewController.h"

@interface AppDelegate () <PILoginDelegate>
{
    PILoginViewController *_loginVC;
    PILaunchViewController *_launchVC;
}

@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    // Override point for customization after application launch.
//    [self showInitialScreen];

    UIStoryboard *chatStoryboard = [UIStoryboard storyboardWithName:@"QAStoryboard" bundle:nil];
    PITestLaunchViewController *testLaunchViewController = (PITestLaunchViewController*)[chatStoryboard instantiateInitialViewController];
    self.window.rootViewController = testLaunchViewController;
    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application {
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application {
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later.
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application {
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application {
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application {
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}


#pragma mark - Launch appropriate UI -

- (void)showInitialScreen {
    BOOL isLoggedIn = [[NSUserDefaults standardUserDefaults]boolForKey:kIsUserLoggedIn];
    if (isLoggedIn) {
        [self showLaunchScreen];
    }
    else {
        [self showLoginScreen];
    }
}

- (void)showLoginScreen {
    if (_loginVC == nil) {
        UIStoryboard *mainStoryboard = [UIStoryboard storyboardWithName:StoryboardNameMain bundle:[NSBundle mainBundle]];
        _loginVC = [mainStoryboard instantiateViewControllerWithIdentifier:StoryboardIDLoginVC];
    }
    self.window.rootViewController = _loginVC;
    
}

- (void)showLaunchScreen {
    if (_launchVC == nil) {
        UIStoryboard *mainStoryboard = [UIStoryboard storyboardWithName:StoryboardNameMain bundle:[NSBundle mainBundle]];
        _launchVC = [mainStoryboard instantiateViewControllerWithIdentifier:StoryboardIDLaunchVC];
    }
}

#pragma mark - login delegate -

- (void)loginDidSuccess {
    
}

@end
