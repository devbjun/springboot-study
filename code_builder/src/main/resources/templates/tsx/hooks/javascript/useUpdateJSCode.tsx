import { useDispatch } from 'react-redux';
import { useCallback } from 'react';
import { updateJSCode } from '../../models/javascript';

export const useUpdateJSCode = () => {
  const dispatch = useDispatch();
  return useCallback((code) => dispatch(updateJSCode(code)), [dispatch]);
};
