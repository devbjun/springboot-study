import React, { useEffect, useState } from 'react';
import axios from 'axios';

import { useData } from '../../hooks/data/useData';
import { useUpdateResult } from '../../hooks/data/useUpdateResult';

export default () => {

  const data = useData();
  const updateResult = useUpdateResult();

  const onClickHandler = (e: any) => {
    axios.post('http://localhost:8000/build', { code: data.code })
    .then((res) => {
      updateResult({
        state: (res.data.search('Exception') != -1) ? 'error' : ((res.data == 'undefined') ? 'warning' : 'success'),
        message: (res.data.search('Exception') != -1) ? res.data : ((res.data == 'undefined') ? 'No results.' : res.data)
      })
    })
    .catch((err) => updateResult({
      state: 'error',
      message: err
    }));
  }

  return (
    <div className="header">
      <nav className="navbar is-dark" role="navigation" aria-label="main navigation">
        <div className="navbar-brand">
          <a className="navbar-item" href="/">
            <img src="/img/logo.png" width="112" height="28" />
          </a>
          
          <div className="navbar-item" style={{ position: 'absolute', top: -2.5, right: 0 }}>
            <div className="button is-primary" onClick={ onClickHandler } style={{ width: '75px' }}>
              <strong>Run</strong>
            </div>
          </div>
        </div>
      </nav>
    </div>
  );  
};