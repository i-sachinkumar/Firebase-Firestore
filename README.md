# Firebase-Firestore


### Steps:

<br>
1. In your android studio project: <br>
 -> Go to "Tools" tab -> Select firebase -> a panel will open
 
 <br><br>
2. Choose "Analytics" -> "Get Started with Google Analytics"

<br>
<br>
3. Go to "Connect to Firebase" option, will open browser and let you create a new project on firebase

<br>
<br>
4. Go to "Add analytics SDK to your app" after connecting, it will add following analytics dependency in app level gradle file

```
implementation 'com.google.firebase:firebase-analytics-ktx:21.0.0'
```

<br>
<br>
5. Now add one more dependency (provide below) and sync project

```
implementation 'com.google.firebase:firebase-firestore-ktx:21.0.0'
```

<br>
<br>
6. Go to firebase account, select firestore tab from panel -> Create Database -> start in test mode
