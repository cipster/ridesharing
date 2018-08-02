import {Action} from "@ngrx/store";
import {User} from "../interfaces/user";

export const UPDATE_TOKEN = 'UPDATE_TOKEN';
export const UPDATE_USER = 'UPDATE_USER';

export class UpdateTokenAction implements Action {
  readonly type: string = UPDATE_TOKEN;
  constructor(public token: string) { }
}

export class UpdateUserAction implements Action {
  readonly type: string = UPDATE_USER;
  constructor(public user: User) { }
}

