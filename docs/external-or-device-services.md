# Device/external services

## Device Services

* Device's Camera.

    * [Documentation](https://developer.android.com/reference/android/hardware/camera2/package-summary)
    
    * The camera is necessary to be able to scan any qr codes that the user would like to scan to 
    receive deck lists.
    
    * The camera is not critical to the main functionality of the application and without it only the 
    qr code scanning portion of the app will not work.

## External services

* QRCode Scanner

    * [Documentation](https://developers.google.com/ml-kit/vision/barcode-scanning/android)
    
    * A library that will allow the camera to read QRCodes.
     
    * The app will be able to run without QRCode Scanner but will lose the QR code functionality.
    
* Google Sign-In

    * [Documentation](https://developers.google.com/identity/sign-in/android/start-integrating)
    
    * The Sign-in will enable the user to associate certain data with their account.
    
[*Return to previous page*](index.md)

