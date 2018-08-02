import {Action} from '@ngrx/store';
import {AuthState} from "../interfaces/auth.state";
import * as AuthActions from '../actions/auth.actions'

export const initialState: AuthState = {
  token: null,
  user: {
    username: '',
    firstName: '',
    lastName: '',
    phone: '',
    email: '',
    type: null,
    ratings: null,
    ownedCars: null,
    rideHistory: null
  }
}

export function reducer(state: AuthState = initialState, action: Action){
  switch (action.type){
    case AuthActions.UPDATE_TOKEN:
      return Object.assign({}, state, {
        token: (action as AuthActions.UpdateTokenAction).token
      });
    case AuthActions.UPDATE_USER:
      return Object.assign({}, state, {
        user: (action as AuthActions.UpdateUserAction).user
      });
    default: return state;
  }
}
