import { useDispatch } from 'react-redux';
import { useCallback } from 'react';
import { updateJSResult } from '../../models/javascript';

export const useUpdateJSResult = () => {
  const dispatch = useDispatch();
  return useCallback((result) => dispatch(updateJSResult(result)), [dispatch]);
};
