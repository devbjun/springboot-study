import React, { useEffect } from 'react';

import { useData } from '../../../hooks/data/useData';
import { useUpdateResult } from '../../../hooks/data/useUpdateResult';

export default () => {

  const data = useData();
  const updateResult = useUpdateResult();

  useEffect(() => {
    updateResult({
      state: 'wait',
      message: 'Not Executed Code!'
    });
  }, []);

  return (
    <div className="console has-background-grey-darker" style={{ position: 'relative', top: '50px', height: 'calc(50% - 50px)' }}>
      <article className={ 'tile is-child notification ' + 
        ((data.result.state == 'wait') ? 'is-primary' : ((data.result.state == 'error') ? 'is-danger' : ((data.result.state == 'warning') ? 'is-warning' : 'is-success')))
      } style={{ top: '50%', left: '50%', width: 'calc(100% - 25px)', height: 'calc(100% - 25px)', transform: 'translate(-50%, -50%)' }}>
        <p className="title">Node Execution Results</p>
        <p className="subtitle">&gt; node index.js</p>
        <div className="content">
          {data.result.message}
        </div>
      </article>
    </div>
  );
};