# ProfileRequest
ProfileRequest
The app has following packages:
1 ) core: It contains AppViewModeFactory  that provides {@code ViewModels} for a scope..

2 ) data: It contains folder api, model and repo
   api: contains GET request and BASE URL
   model: contains model for profile
   repo: contains classes for response

3 ) di: Dependency providing classes using Dagger2
    component:contains appcomponent file
    mapkey : contains annotation file
    module : contains network, viewmodelmodule and other files

4 ) home: contains adapter, activity and viewmodel of Home page
