import { useDispatch } from 'react-redux';
import { useCallback } from 'react';
import { updateResult } from '../../models/data';

export const useUpdateResult = () => {
  const dispatch = useDispatch();
  return useCallback((result) => dispatch(updateResult(result)), [dispatch]);
};
