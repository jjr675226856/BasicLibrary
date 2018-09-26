# BasicLibrary
Android基础依赖 
使用它
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.jjr675226856:BasicLibrary:v1.0.0'
	}
