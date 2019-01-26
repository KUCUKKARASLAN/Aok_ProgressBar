
# Aok_ProgressBar  [![Generic badge](https://img.shields.io/badge/0.1.0-Version-4286f4.svg)](https://github.com/KUCUKKARASLAN/Aok_ProgressBar)
Android Progress Bar Design Customization

# Preview 
![Android Progress Bar Design Customization](https://github.com/KUCUKKARASLAN/Aok_ProgressBar/blob/master/screenshots/1.png)

# Gradle
>Easily reference the library in your Android projects using this dependency in your module's build.gradle file:
```
dependencies {
	 implementation 'com.github.KUCUKKARASLAN:Aok_ProgressBar:0.1.0'
	}
```
>Add repository to your app's build.gradle file:
```
repositories {
    maven {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

# XML Layout
```xml
 <com.aoktest.library.aok_Progress
        android:id="@+id/progressTest"
        android:layout_width="match_parent"
        android:layout_height="30dp"
        android:layout_margin="10dp"
        app:aokProgresBackColor="#FF9800"
        app:aokProgresMax="100"
        app:aokProgresValue="0"
        app:aokProgresingColor="#8BC34A" />
```

# Java

```java 
aok_Progress progressTest = (aok_Progress) findViewById(R.id.progressTest);
progressTest.setmProgresMax(100); //Max Value - Default 100
progressTest.setmProgresValue(20); //Progresing Value - Default 50
```
 
 # Customizing
 All attributes can be defined in layout .xml file or programmatically. Below is a list of available attributes.
 ```xml
   <declare-styleable name="aok_Progress">
        <attr name="aokProgresBackColor" format="color"/>
        <attr name="aokProgresingColor" format="color"/>
        <attr name="aokProgresMax" format="integer"/>
        <attr name="aokProgresValue" format="integer"/>
    </declare-styleable>
 ```
 
