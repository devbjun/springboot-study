import { ActionType } from 'typesafe-actions';
import * as actions from './actions';

export type PythonState = {
  code: string,
  result: {
    state: string,
    message: string
  }
};
export type PythonAction = ActionType<typeof actions>
