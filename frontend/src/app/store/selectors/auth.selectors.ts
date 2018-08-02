import { createSelector } from 'reselect';
import { AppState } from '../interfaces/app.state';
import { AuthState } from '../interfaces/auth.state';

export const getAuthState = (state: AppState) => state.auth;

// export const isAuthenticated = createSelector(getAuthState, (auth: AuthState) => auth.isAuthenticated);

export const token = createSelector(getAuthState, (auth: AuthState) => auth.token);
