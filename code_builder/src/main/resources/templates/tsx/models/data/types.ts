import { ActionType } from 'typesafe-actions';
import * as actions from './actions';

export type DataState = {
  code: string,
  result: {
    state: string,
    message: string
  }
};
export type DataAction = ActionType<typeof actions>
