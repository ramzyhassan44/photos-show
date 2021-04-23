
<h1 align="center"> PhotoShow </h1>  
  
<p align="center">  
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>  
  <a href="https://android-arsenal.com/api?level=29"><img alt="API" src="https://img.shields.io/badge/API-29%2B-brightgreen.svg?style=flat"/></a>  
  <a href="https://kotlinlang.org"><img alt="Kotlin" src="https://img.shields.io/badge/Kotlin-1.4.xxx-blue"/></a>  
  <img alt="MVVM" src="https://img.shields.io/badge/MVVM-Architecture-orange"/>  
  <a href="https://developer.android.com/kotlin/coroutines"><img alt="Coroutines" src="https://img.shields.io/badge/Coroutines-Asynchronous-red"/></a>  
</p>  

<p align="center">  
PhotoShow app is a small demo application that allows user to capture photos and show previously captured photos in which I demonstrate modern Android application tech-stacks and MVVM architecture.  
</p>  
  
## Tech stack & Open-source libraries  
- Minimum SDK level 21  
- [Kotlin](https://kotlinlang.org/)  
- [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)  
- [JetPack](https://developer.android.com/jetpack)  
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Notify domain layer data to views.  
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Dispose of observing data when lifecycle state changes.  
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Allows you to more easily write code that interacts with views  
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - UI related data holder, lifecycle aware.  
  - [Room Persistence](https://developer.android.com/training/data-storage/room) - construct a database using the abstract layer.  
- Architecture  
  - MVVM Architecture (View - ViewModel - Model)  
  - Repository pattern  
  - Clean Architecture approach.  
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components.  
- Testing  
  - [Junit](https://junit.org/junit4/) 
  - [Mockk](https://mockk.io)- used for mocking
  - [Arch-Component](https://developer.android.com/jetpack/androidx/releases/arch-core) - help in testing live data
  - [Coroutines Testing](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-test/) - used for testing coroutines
  - [Espresso](https://developer.android.com/training/testing/espresso) - Used for UI testing
  
## Architecture  
PhotoShow application with a meaningful separation for layers and features with the necessary grouping. Using MVVM architecture. I used core and shell concept to implement clean architecture idea in which I separate the business logic and non-platform related stuff in core package that allows us to scale easily and if we decided to us [KMM](https://kotlinlang.org/docs/multiplatform.html) we can easily take this core package with small modification. 
- App  
  - Core:  
    - data [holds the application data objects]
    - routers [holds the app routing contract]
    - usecases [holds business logic usecases]
    - validators  [holds our app validators]
    - viewmodels [holds all viewmodels the communicate between the app view and usecases]
  - Shell:  
    - app [holds the app class]
    - repos [holds the repos implementation for core repos]
    - routers [holds the actual routing logic that implements the router contract from core]
    - source [holds the persistence logic]
    - ui [holds the app features UI]
    - utils [holds some helpers class]
    
    
  ![Application Flow Diagram]()  

  
## Tasks  

 - Creating the project structure with Initial packaging. 
 - Implement Usecase and write unit tests for it. 
 - Implement ViewModels.
 - Finalize features.
 - Finalize unit tests.

## TODO  

 - Increase test coverage. 
 - Use multi-modules arch. 
 - Use Gradle Kotlin DSL. 
 - Use Navigation component.  
 - Integrate SonarQube 
 - Integrate Github Actions. 
  
# License  
```xml  
Designed and developed by 2021 Ramzy Hassan  
  
Licensed under the Apache License, Version 2.0 (the "License");  
you may not use this file except in compliance with the License.  
You may obtain a copy of the License at  
  
 http://www.apache.org/licenses/LICENSE-2.0  
Unless required by applicable law or agreed to in writing, software  
distributed under the License is distributed on an "AS IS" BASIS,  
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  
See the License for the specific language governing permissions and  
limitations under the License.  
```
