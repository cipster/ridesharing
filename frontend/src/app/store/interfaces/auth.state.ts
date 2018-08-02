import { User } from "./user";

export interface AuthState{
  token: string;
  user: User;
}
