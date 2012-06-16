#Read Me

##Description

These classes implement a basic API for the Xcode project file (works also with Xcode 4.3.x).

Note: *The low level classes in the ```com.sap.prd.mobile.ios.mios.xcodeprojreader.jaxb``` package can be used to load and save arbitrary property lists.*

##Usage
See [UsageExamples.java](https://github.com/sap-production/XcodeProjectJavaAPI/blob/master/src/test/java/com/sap/prd/mobile/ios/mios/xcodeprojreader/UsageExamples.java).

##Known limitations

In order to use this library, you have to convert the Xcode project file to XML (see ```convert``` method in [JAXBPlistParser.java](https://github.com/sap-production/XcodeProjectJavaAPI/blob/master/src/main/java/com/sap/prd/mobile/ios/mios/xcodeprojreader/jaxb/JAXBPlistParser.java). This step can only be done on Mac OS X. The project file cannot be converted back!

The remainder of the API uses standard Java features.