//
//  LRNContainerView.h
//  LottieReactNative
//
//  Created by Leland Richardson on 12/12/16.
//  Copyright © 2016 Airbnb. All rights reserved.
//


// import RCTView.h
#if __has_include(<React/RCTView.h>)
#import <React/RCTView.h>
#elif __has_include("RCTView.h")
#import "RCTView.h"
#else
#import "React/RCTView.h"
#endif

#import "PublicHeaders/Lottie.h"

@interface LRNContainerView : RCTView

@property (nonatomic, assign) BOOL loop;
@property (nonatomic, assign) CGFloat speed;
@property (nonatomic, assign) CGFloat progress;
@property (nonatomic, strong) NSDictionary *sourceJson;
@property (nonatomic, strong) NSString *sourceName;
@property (nonatomic, copy) NSNumber *blur;
@property (nonatomic, copy) CGFloat *alpha;

- (void)play;
- (void)playFromFrame:(NSNumber *)startFrame
              toFrame:(NSNumber *)endFrame;
- (void)reset;
- (void)pause;
- (void)resume;


@end
