import { ActionType } from 'typesafe-actions';
import * as actions from './actions';

export enum Language { JAVASCRIPT, PYTHON };
export type LanguageState = Language;
export type LanguageAction = ActionType<typeof actions>
