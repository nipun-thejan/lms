import { FormRow, FormRowSelect } from '.';
import { useAppContext } from '../context/appContext';
import Wrapper from '../assets/wrappers/SearchContainer';
import { useState, useMemo, useEffect, useCallback } from 'react';
import courseService from '../service/CourseService';
import { useSearchParams } from 'react-router-dom';

const CourseSearchContainer = () => {
  const {
    getJobs,
  } = useAppContext();

  const [params, setParams] = useSearchParams();
  const [query, setQuery] = useState("");

  const search = useCallback((query) => {
    courseService.search(query)
      .then(res => {
        getJobs(res)
      }).catch(err => {
        console.log(err);
      });
  }, []);

  useEffect(() => {
    setQuery(params.get('query') || "");
    search(params.get('query') || "");
  }, [search, params]);

  const handleSearch = (e) => {
    e.preventDefault();

    setParams(`?query=${query}`);
    search(query);
  }


  return (
    <Wrapper>
      <form className='form' onSubmit={handleSearch}>
        <h4>search form</h4>
        <div className='form-center'>

          <FormRow
            type='text'
            name='query'
            value={query}
            handleChange={(e) => setQuery(e.target.value)}
          />
          {/* <FormRowSelect
            labelText='status'
            name='searchStatus'
            value={searchStatus}
            handleChange={handleSearch}
            list={['all', ...statusOptions]}
          />
          <FormRowSelect
            labelText='type'
            name='searchType'
            value={searchType}
            handleChange={handleSearch}
            list={['all', ...jobTypeOptions]}
          />
          <FormRowSelect
            name='sort'
            value={sort}
            handleChange={handleSearch}
            list={sortOptions}
          /> */}
          {/* <FormRow
            type= "text"
            name='name'
            value={name}
            handleChange={handleChange}
          /> */}
          <button
            className='btn btn-block btn-danger'
            // disabled={isLoading}
            type='submit'
          >
            submit
          </button>
        </div>
      </form>
    </Wrapper>
  );
};

export default CourseSearchContainer;
