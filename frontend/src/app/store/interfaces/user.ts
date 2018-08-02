export interface User{
  username: string;
  firstName?: string;
  lastName?: string;
  phone?: string;
  email: string;
  // TODO: De stabilit tipul pentru type, ratings, ownedCars, rideHistory;
  type?: any;
  ratings?: any;
  ownedCars?: any;
  rideHistory?: any;
}
