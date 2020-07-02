import { useDispatch } from 'react-redux';
import { useCallback } from 'react';
import { updatePyResult } from '../../models/python';

export const useUpdatePyResult = () => {
  const dispatch = useDispatch();
  return useCallback((result) => dispatch(updatePyResult(result)), [dispatch]);
};
