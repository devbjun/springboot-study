import { ActionType } from 'typesafe-actions';
import * as actions from './actions';

export type JavaScriptState = {
  code: string,
  result: {
    state: string,
    message: string
  }
};
export type JavaScriptAction = ActionType<typeof actions>
