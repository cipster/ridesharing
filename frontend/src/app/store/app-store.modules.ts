import {NgModule} from '@angular/core';
import {reducer as authReducer} from './reducers/auth-reducer';
import {ActionReducer, MetaReducer, StoreModule} from "@ngrx/store";
import {localStorageSync} from "ngrx-store-localstorage";
import {StoreDevtoolsModule} from "@ngrx/store-devtools";

const reducers = {
  auth: authReducer
}

const localStorageSyncReducer = (reducer: ActionReducer<any>) => {
  return localStorageSync({
    keys: ['auth'],
    rehydrate: true
  })(reducer);
};

const metaReducer = (reducer: ActionReducer<any>) => {
  // TODO: Configure for production tool
  return localStorageSyncReducer(reducer);
};

const metaReducers: Array<MetaReducer<any, any>> = [metaReducer];

@NgModule({
  imports: [
    StoreModule.forRoot(reducers, {metaReducers}),
    StoreDevtoolsModule.instrument({
      maxAge: 10
    })
    // TODO add effects here, if any
    // EffectsModule.run(WhateverEffects)
  ]
})
export class AppStoreModule{

}
